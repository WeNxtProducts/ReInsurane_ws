package com.vi.corelib.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vi.corelib.api.MicroService;
import com.vi.corelib.config.Config;
import lombok.SneakyThrows;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Configuration
@Component
public class ComputeTax {


    @Autowired
    private Environment env;


    JsonNode taxDetails;
    String shipFrom;
    String shipTo;
    JsonNode tariffs;
    String lobType;
    JsonNode templateDetails;

    public ComputeTax(JsonNode taxDetails, String shipFrom, String shipTo, String lobType) {
        this.taxDetails = taxDetails;
        this.shipFrom = shipFrom;
        this.shipTo = shipTo;
        this.lobType = lobType;

    }
    public Boolean isUnionTeritory(String stateId) {
        if(stateId =="IN-GA" || stateId=="IN-AN" || stateId=="IN-CH" || stateId=="IN_DN" || stateId=="IN-DL" || stateId=="IN-LD" || stateId=="IN-PY" || stateId=="IN-JK") {
            return true;
        } else {
            return false;
        }
    }
    @Bean
    public JsonNode calculate(JsonNode taxDetails, String shipFrom, String shipTo, String lobType) throws IOException, ParseException {
        this.taxDetails = taxDetails;
        this.shipFrom = shipFrom;
        this.shipTo = shipTo;
        this.lobType = lobType;
         getTaxTemplate();
         getHsnDetails();
         return this.tariffs;

    }
    private void getHsnDetails() throws IOException, ParseException {
        MicroService microService = new MicroService();
//        String baseUrl = env.getProperty("server.globals")+"hsns/tariff"; //"http://localhost:8832/hsns/tariff";
        System.out.println(new Config().getProperty("server.globals"));
        String url = new Config().getUrl("server.kafkaFilePath","globals");
//        String baseUrl = new Config().getProperty("server.globals")+"hsns/tariff";
        System.out.print("Glboals Url" + url);
        String baseUrl = url+"/hsns/tariff";
        String path = UrlUtility.queryStringify(baseUrl,taxDetails);

        Object response = microService.getData(path,"",null,"internal");
        this.tariffs  =JsonHelper.stringToJson((String) response);
    }
    private void getTaxTemplate() throws IOException, ParseException {
        MicroService microService = new MicroService();
        //String baseUrl = env.getProperty("server.globals");
//        String baseUrl = env.getProperty("server.globals")+"taxtemplates/apply";//"http://localhost:8832/taxtemplates/apply";
        String url = new Config().getUrl("server.kafkaFilePath","globals");
        System.out.print("Glboals Url");
        System.out.print(url);
        String baseUrl = url+"/taxtemplates/apply";

        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        if(this.taxDetails.get("customerType").asText().toLowerCase().contains("sez")) {
            objectNode.put("applyTo", this.taxDetails.get("customerType").asText().toUpperCase());
        }
        else if(!this.shipFrom.equals(this.shipTo)) {
            objectNode.put("applyTo","INTERSTATE");
        } else if(isUnionTeritory(this.shipTo)) {
            objectNode.put("applyTo","UNION");
        } else {
            objectNode.put("applyTo","INTRASTATE");
        }
        objectNode.put("effectiveDate",taxDetails.get("effectiveDate").asText());
        objectNode.put("lobType",this.lobType);

        String path = UrlUtility.queryStringify(baseUrl,objectNode);
        Object response = microService.getData(path,"",null,"internal");
        this.templateDetails  =JsonHelper.stringToJson((String) response);
        StringBuilder str = new StringBuilder();
        for(JsonNode detail : this.templateDetails.get("data")) {
            str.append(",").append(detail);
        }
        ((ObjectNode) this.taxDetails).put("componentId", str.substring(1));
        //return this.templateDetails.toString();

    }
}

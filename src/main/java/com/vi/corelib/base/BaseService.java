package com.vi.corelib.base;

import java.util.List;

public interface BaseService<T> {
  List<T> fetchAll();

  T get(int id);
  T get(Long id);

  T create(T t);

  T update(T t);
  //T delete(int id);

  Boolean delete(int id);
  Boolean delete(Long id);

}

package com.vi.corelib.base;

import java.util.List;

public interface BaseService<T> {
  List<T> fetchAll();

  T get(Long id);
  T get(int id);

  T create(T t);

  T update(T t);

  Boolean delete(Long id);
  Boolean delete(int id);

}

package modules.basic.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yang on 2017/2/18.
 */
@Service
public interface BaseService<T> {
    public int add(T t);

    public int delete(String id);

    public int update(T t);

    public T getOne(String id);

    public List<T> getAll();
}

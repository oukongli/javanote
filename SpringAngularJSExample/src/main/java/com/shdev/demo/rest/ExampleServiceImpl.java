package com.shdev.demo.rest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ou_ko on 2016/8/5.
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
    public ExampleModel get(String id) {
        return new ExampleModel("example", 1001);
    }

    public List<ExampleModel> getAll(String id) {
        final ExampleModel model_1 = new ExampleModel("name1", 1001);
        final ExampleModel model_2 = new ExampleModel("name2", 1002);
        return new ArrayList<ExampleModel>() {{
            add(model_1);
            add(model_2);
        }};
    }
}

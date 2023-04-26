package com.example.demo.Controller;


import com.example.demo.Service.Convert;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class ReadController {
    @Autowired
    Convert convert;
    @PostMapping("/object")
    public List<Map<String,String>> json1(@RequestBody List<Map<String,String>> objects) throws JSONException, IOException {
//        convert.change(objects);
        convert.doChange(objects);
        return objects;
    }

}

package com.code.FirstSpringAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This controller will be containing HTTP API's
//localhost:8080/sample
@RestController
@RequestMapping("/sample")
public class SampleController
{
    //localhost:8080/sample/sayHello/Deepak
    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name)
    {
        return "Hey " + name;
    }

    //localhost:8080/sample/sayBye
    @GetMapping("/sayBye")
    public String sayBye()
    {
        return "Bye Everyone";
    }


}

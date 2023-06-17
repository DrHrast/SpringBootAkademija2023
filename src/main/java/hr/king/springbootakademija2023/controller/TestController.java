package hr.king.springbootakademija2023.controller;

import hr.king.springbootakademija2023.dto.TestDto;
import hr.king.springbootakademija2023.form.TestForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/test")
public class TestController {

    @GetMapping(value = "/get")
    public String testGet() {
        return "OK";
    }

    @GetMapping(value = "/get/{param}")
    public String testGetWithParam(@PathVariable String param){
        return param;
    }

    @GetMapping(value = "/getResponse")
    public ResponseEntity<String> testResponseGet(){
        return ResponseEntity
                .internalServerError()
                .header("testniHeader", "bla bla")
                .body("Greška");
    }

    @GetMapping(value = "/getDto")
    public ResponseEntity<TestDto> testGetDto(){
        TestDto testDto = new TestDto();
        testDto.setName("Ime");
        testDto.setDescription("opis");

        return ResponseEntity
                .ok()
                .body(testDto);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<TestDto> testPostWithParam(@RequestBody @Valid TestForm testForm){

        TestDto testDto = new TestDto();
        testDto.setName(testForm.getName());
        testDto.setDescription(testForm.getDescription());

        return ResponseEntity
                .ok()
                .body(testDto);
    }
}

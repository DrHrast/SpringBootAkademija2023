package hr.king.springbootakademija2023.service.implementation;

import hr.king.springbootakademija2023.service.PageSuffixService;
import org.springframework.stereotype.Service;

@Service("html")
public class PageSuffixServiceHtml implements PageSuffixService {
    @Override
    public String getSuffix(){
        return "html";
    }
}

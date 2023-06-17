package hr.king.springbootakademija2023.service.implementation;

import hr.king.springbootakademija2023.service.DashboardService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!test & !prod")
public class DashboardServiceDefault implements DashboardService {
    @Override
    public String getDashboard(){
        return "dashboard";
    }
}

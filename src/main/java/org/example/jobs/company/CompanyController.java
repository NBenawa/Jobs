package org.example.jobs.company;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("companies/{id}")
    public Company getCompany(@PathVariable int id) {
        return companyService.getCompany(id);
    }

    @PostMapping("companies")
    public String createCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return "Company created successfully!";
    }

    @PutMapping("companies/{id}")
    public String updateCompany(@PathVariable int id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
        return "Company updated successfully!";
    }

    @DeleteMapping("companies/{id}")
    public String deleteCompany(@PathVariable int id) {
        companyService.removeCompany(id);
        return "Company deleted successfully!";
    }
}

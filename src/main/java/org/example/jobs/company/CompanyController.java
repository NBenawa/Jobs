package org.example.jobs.company;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable int id) {
        return companyService.getCompany(id);
    }

    @PostMapping
    public String createCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return "Company created successfully!";
    }

    @PutMapping("/{id}")
    public String updateCompany(@PathVariable int id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
        return "Company updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable int id) {
        companyService.removeCompany(id);
        return "Company deleted successfully!";
    }
}
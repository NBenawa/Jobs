package org.example.jobs.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable int id) {
        Company company = companyService.getCompany(id);
        return company != null ? ResponseEntity.ok(company) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company created successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable int id, @RequestBody Company company) {
        boolean updated = companyService.updateCompany(id, company);

        if (updated) {
            return ResponseEntity.ok("Company updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id) {
        boolean deleted = companyService.removeCompany(id);

        if (deleted) {
            return ResponseEntity.ok("Company deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found!");
        }
    }
}
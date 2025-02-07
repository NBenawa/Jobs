package org.example.jobs.company;

import java.util.List;

public interface CompanyService {
    boolean addCompany(Company company);
    boolean removeCompany(int id);
    boolean updateCompany(int id, Company company);
    List<Company> getAllCompanies();
    Company getCompany(int id);
}

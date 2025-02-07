package org.example.jobs.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public boolean addCompany(Company company) {
        companyRepository.save(company);
        return true;
    }

    @Override
    public boolean removeCompany(int id) {
        companyRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCompany(int id, Company updatedCompany) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company != null) {
            company.setName(updatedCompany.getName());
            return true;
        }
        return false;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(int id) {
        return companyRepository.findById(id).orElse(null);
    }
}

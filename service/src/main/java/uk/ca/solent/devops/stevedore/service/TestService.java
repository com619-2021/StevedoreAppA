package uk.ca.solent.devops.stevedore.service;

import org.springframework.stereotype.Service;
import uk.ca.solent.devops.stevedore.model.TestModel;
import uk.ca.solent.devops.stevedore.repository.TestRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @PostConstruct
    public void initTest(){
        testRepository.saveAll(new ArrayList<TestModel>() {{
            new TestModel(1L, "Test");
        }});
    }

    public List<TestModel> getAllTest(){
        return StreamSupport.stream(testRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}

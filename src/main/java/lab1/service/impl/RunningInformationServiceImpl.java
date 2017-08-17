package lab1.service.impl;

import lab1.domain.RunningInformation;
import lab1.domain.RunningInformationRepository;
import lab1.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RunningInformationServiceImpl implements RunningInformationService{

    @Autowired
    private RunningInformationRepository runningInformationRepository;

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations) {
        return runningInformationRepository.save(runningInformations);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningInformationRepository.deleteByRunningId(runningId);
    }

    @Override
    public void deleteAll() {
        runningInformationRepository.deleteAll();
    }

    @Override
    public Page<RunningInformation> findAllOrderByHeartRate(Pageable pageable) {
        return runningInformationRepository.findAllByOrderByHeartRateDesc(pageable);
    }
}

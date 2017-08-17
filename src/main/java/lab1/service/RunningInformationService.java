package lab1.service;

import lab1.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformations);

    Page<RunningInformation> findAllOrderByHeartRate(Pageable pageable);

    void deleteByRunningId(String runningId);

    void deleteAll();
}

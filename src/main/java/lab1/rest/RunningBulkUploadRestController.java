package lab1.rest;

import lab1.domain.Response;
import lab1.domain.RunningInformation;
import lab1.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RunningBulkUploadRestController {
    @Autowired
    public RunningInformationService runningInformationService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformations) {
        runningInformationService.saveRunningInformation(runningInformations);
    }

    @RequestMapping(value = "/delete/id/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId){
        runningInformationService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public List<Response> findAllOrderByHeatRate(@RequestParam(name = "page") int page) {
        Page<RunningInformation> infos = runningInformationService.findAllOrderByHeartRate(new PageRequest(page, 2));
        List<Response> res = new ArrayList<>();
        for (RunningInformation runInfo : infos.getContent()) {
            res.add(new Response(
                    runInfo.getRunningId(),
                    runInfo.getTotalRunningTime(),
                    runInfo.getHeartRate(),
                    runInfo.getId(),
                    runInfo.getUserInfo().getUsername(),
                    runInfo.getUserInfo().getAddress(),
                    runInfo.getHealthWarningLevel()));
        }
        return res;
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
    public void deleteAll(){
        runningInformationService.deleteAll();
    }
}

package springcloud.sericefeign;

import org.springframework.stereotype.Component;

/**
 * @Author: zhoujinliang
 * @Date: 2018/12/6 19:11
 * @Description:
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHifFromClientOne(String name) {
        return "sorry " + name;
    }
}

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author karma
 * @date 2022-08-12
 * @desc
 */
@Slf4j
public class GuavaRateLimiter {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1 / (double) 5);
        int last = 0;
        for (int i = 0; i < 12; i++) {
            last = i;
            new Thread(() -> {
                // 获取 1 个令牌
                if (rateLimiter.tryAcquire(5, TimeUnit.SECONDS)) {
                    log.info("正常执行方法，ts：{}", LocalDateTime.now());
                }
            }, "rateLimiter:" + i).start();
        }
        log.info("last:{}", last);
        new Thread(() -> {

        });
    }
}

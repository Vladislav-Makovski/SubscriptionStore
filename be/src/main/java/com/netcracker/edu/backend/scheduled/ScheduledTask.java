//package com.netcracker.edu.backend.scheduled;
//
//import com.netcracker.edu.backend.entity.Subscription;
//import com.netcracker.edu.backend.service.SubscriptionService;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.util.List;
//
//@EnableScheduling
//public class ScheduledTask {
//
//    private SubscriptionService subscriptionService;
//
//    @Scheduled(cron = "0 0 1 * *")
//    public void reportCurrentTime() {
//        List<Subscription> subs = subscriptionService.getAllSubscription();
//        for (Subscription sub: subs) {
//
//        }
//    }
//}

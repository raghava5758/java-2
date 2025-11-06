package com.example.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringHibernateConfig.class);
        AccountService service = ctx.getBean(AccountService.class);

        try {
            service.transferMoney(1, 2, 500);
            System.out.println("Transaction Successful!");
        } catch (Exception e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }

        ctx.close();
    }
}

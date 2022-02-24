package com.fazliddin.newwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Fazliddin Xamdamov
 * @date 24.02.2022  10:52
 * @project New-Warehouse
 */
@Service
public class MessageService {

    @Autowired
    private static MessageSource messageSource;

    @Autowired
    public void helper(MessageSource messageSource) {
        MessageService.messageSource = messageSource;
    }

    public static String getMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public static String merge(String action, String termin) {
        return String.format(getMessage(action), getMessage(termin));
    }


    /*==================SUCCESS===================*/

    public static String successEdit(String termin) {
        return merge("SUCCESS_EDIT", termin);
    }

    public static String successSave(String termin) {
        return merge("SUCCESS_SAVE", termin);
    }

    public static String successDelete(String termin) {
        return merge("SUCCESS_DELETE", termin);
    }


    /*===================ERROR===================*/

    public static String cannotDelete(String termin) {
        return merge("CANNOT_DELETE", termin);
    }

    public static String notFound(String termin) {
        return merge("NOT_FOUND", termin);
    }

    public static String alreadyExists(String termin) {
        return merge("ALREADY_EXISTS", termin);
    }

}

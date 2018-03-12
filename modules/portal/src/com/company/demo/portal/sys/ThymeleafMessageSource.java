package com.company.demo.portal.sys;

import com.haulmont.cuba.core.global.Messages;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import javax.inject.Inject;
import java.util.Locale;

public class ThymeleafMessageSource implements MessageSource {
    @Inject
    private Messages messages;

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        if (args != null && args.length > 0) {
            return messages.formatMainMessage(code, args, locale);
        }

        return messages.getMainMessage(code, locale);
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        if (args != null && args.length > 0) {
            return messages.formatMainMessage(code, args, locale);
        }

        return messages.getMainMessage(code, locale);
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        throw new NoSuchMessageException("Unsupported message resolving mechanism");
    }
}
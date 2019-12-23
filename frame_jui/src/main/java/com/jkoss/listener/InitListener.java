package com.jkoss.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jkoss.framejui.system.entity.Dictionary;
import com.jkoss.framejui.system.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jkoss.common.constant.Constant;
import com.jkoss.common.util.CommonUtil;

import java.util.HashMap;
import java.util.List;

@Component
public class InitListener implements ServletContextListener {

    @Value("${app.basePath}")
    private String basePath;
    @Autowired
    private IDictionaryService iDictionaryService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //查出字典数据,将数字字典的内容放到application作用域里面
        List<Dictionary> dictionaryList = iDictionaryService.list();
        if (!CommonUtil.isBlank(dictionaryList)) {
            HashMap<String, Object> dictionaryMap = new HashMap<>();
            for (Dictionary dictionary : dictionaryList) {
                dictionaryMap.put(dictionary.getDkey(), dictionary.getDvalue());
            }
            sce.getServletContext().setAttribute("dictionary", dictionaryMap);
        }
        if (CommonUtil.isBlank(basePath)) {
            sce.getServletContext().setAttribute(Constant.APPLICATION_BASEPATH_KEY, sce.getServletContext().getContextPath());
        } else {
            sce.getServletContext().setAttribute(Constant.APPLICATION_BASEPATH_KEY, basePath);
        }
    }
}

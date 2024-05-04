package listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 20:32
 * @Description: listener
 * @version: 1.0
 */
@WebListener
public class RequestLogListener implements ServletRequestListener {
    private static Logger logger;
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
static {
        logger=Logger.getLogger(RequestLogListener.class);
}
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req=(HttpServletRequest)sre.getServletRequest();
        String remoteHost = req.getRemoteHost();
        String requestURL = req.getRequestURL().toString();
        String reqDate = simpleDateFormat.format(new Date());
        logger.info(remoteHost+" "+requestURL+" "+reqDate);
    }
}

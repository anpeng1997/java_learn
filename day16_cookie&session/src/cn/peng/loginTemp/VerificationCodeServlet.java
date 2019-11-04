package cn.peng.loginTemp;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/VerificationCodeServlet")
public class VerificationCodeServlet extends HttpServlet {
    private static final char[] codeChats = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final int width = 200;
    private static final int height = 50;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.cyan); //设置背景颜色
        graphics.fillRect(0,0,width,height);
        graphics.setColor(Color.green); //设置字体颜色
        Random random = new Random();
        String code="";
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(codeChats.length);
            code = code+ codeChats[index];
            graphics.drawString((codeChats[index]) + "", width / 5 * i, height / 2);
        }
        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

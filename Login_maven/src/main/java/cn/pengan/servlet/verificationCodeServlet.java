package cn.pengan.servlet;

import com.sun.org.apache.xpath.internal.operations.String;

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

@WebServlet("/verificationCodeServlet")
public class verificationCodeServlet extends HttpServlet {
    private static final char[] codeChats = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final int width = 150;
    private static final int height = 40;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.YELLOW); //设置背景颜色
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.red); //设置字体颜色
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(codeChats.length);
            code.append(codeChats[index]);
            graphics.drawString((codeChats[index]) + "", width / 5 * i, height / 2);
        }
        HttpSession session = request.getSession();
        session.setAttribute("verification_code", code.toString());
        ImageIO.write(bufferedImage, "jpeg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

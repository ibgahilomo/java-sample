import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckGuess")
public class CheckGuess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int guess = Integer.parseInt(request.getParameter("guess"));
        int secretNumber = (int) (Math.random() * 100) + 1; // Generate a random number between 1 and 100
        String message = "";

        if (guess < secretNumber) {
            message = "Too low! Try again.";
        } else if (guess > secretNumber) {
            message = "Too high! Try again.";
        } else {
            message = "Congratulations! You guessed the number.";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

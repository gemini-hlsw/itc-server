package itc

import edu.gemini.itc.web.servlets.JsonServlet
import edu.gemini.itc.web.servlets.JsonChartServlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletHandler
import org.eclipse.jetty.servlet.ServletHolder
import javax.servlet.http.{ HttpServlet, HttpServletRequest, HttpServletResponse }
import javax.servlet.http.HttpServletResponse.{ SC_BAD_REQUEST, SC_OK }

object Main {

  def main(args: Array[String]): Unit = {

    // Let's not connect to the window server
    System.setProperty("java.awt.headless", "true")
    val hash = BuildInfo.version.toString

    // Construct a server on `PORT` or 8080 if not provided
    val port    = sys.env.get("PORT").fold(8080)(_.toInt)
    val server  = new Server(port)
    val handler = new ServletHandler()
    println(BuildInfo)

    // Set up our handler
    handler.addServletWithMapping(new ServletHolder(new JsonServlet(hash)), "/json")
    handler.addServletWithMapping(new ServletHolder(new JsonChartServlet(hash)), "/jsonchart")
    handler.addServletWithMapping(new ServletHolder(new VersionServlet(hash)), "/version")

    // And start our server
    server.setHandler(handler)
    server.start()
    server.join()

  }

}

class VersionServlet(versionToken: String) extends HttpServlet {

  override def doGet(req: HttpServletRequest, res: HttpServletResponse) = {
    res.setStatus(SC_OK)
    res.setContentType("text/json; charset=UTF-8")
    val writer = res.getWriter // can only be called once :-\
    writer.write(s"""{"versionToken": "$versionToken"}""")

  }

}

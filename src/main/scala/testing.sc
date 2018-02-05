import scala.io.Source
import ApacheLogParser.parse

val lines = Source.fromFile("/home/eric/random_projects/server_logs/src/resources/access_log").getLines()


val s = """64.242.88.10 - - [07/Mar/2004:16:05:49 -0800] "GET /twiki/bin/edit/Main/Double_bounce_sender?topicparent=Main.ConfigurationVariables HTTP/1.1" 401 12846"""

parse(s)


val a = List[Any](1, "whatever", 5.7654)

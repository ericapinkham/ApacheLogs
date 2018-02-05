object ApacheLogParser {
  // Construct the regex pattern
  private val pattern = "^(" + List(
    """.+?""", // host
    """.+?""", // RFC1413
    """.+?""", // userid
    """\[\d{2}/[a-zA-Z]{3}/\d{4}:\d{2}:\d{2}:\d{2}\s[\+-]\d{4}\]""", // timestamp
    """".+?"""", // request
    """\d+?""", // status
    """\d+""" // size
  ).mkString(raw")\s(") + ")$" r

  // parse
  def parse(line: String): Option[List[String]] = {
    pattern.findFirstIn(line).getOrElse("") match {
      case "" => None
      case pattern(host, rfc1413, userid, timestamp, request, status, size) => Some(List(host, rfc1413, userid, timestamp, request, status, size))
      case pattern(_*) => throw new Error("Incorrect RegEx: " + pattern.toString())
    }
  }
}

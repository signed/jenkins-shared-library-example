import org.somecompany.build.ClosureParameters

def call(String input, Closure body) {
    String squareBracket = "[${input}]"
    String parenthesis = "(${input})"
    body.call(new ClosureParameters(squareBracket, parenthesis))
}

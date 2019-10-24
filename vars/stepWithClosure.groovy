/**
 *
 * @param input
 * @param body
 * @return
 */
def call(String input, Closure body) {
    String squareBracket = "[${input}]"
    String parenthesis = "(${input})"
    body.call(squareBracket, parenthesis)
}

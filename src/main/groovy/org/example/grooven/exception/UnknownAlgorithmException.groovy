package org.example.grooven.exception


/**
 * <code>UnknownAlgorithmException</code> indicates that has been
 * returned exception while trying to switching between available crypt-algorithms.
 */
class UnknownAlgorithmException extends RuntimeException {

    /**
     * Default constructor. Message indicates 'The specified algorithm has not been founded!'.
     */
    UnknownAlgorithmException() {
        super("The specified task json-file has not been founded!")
    }

    /**
     * Construct a new {@code UnknownAlgorithmException} with the given message.
     *
     * @param msg The exception message.
     */
    UnknownAlgorithmException(String msg) {
        super(msg)
    }

}

package org.example.grooven.log

import groovy.util.logging.Log


/**
 * This class provides ability to print out log messages while this application running.
 */
@Log
class Logger {

    /**
     * This method shows message box window with information.
     *
     * @param message The information message.
     */
    static infoMessage(String message, Object... params) {
        log.info(String.format(message, params))
    }

    /**
     * This method prints out message with warning information.
     *
     * @param message The warning message.
     */
    static warningMessage(String message, Object... params) {
        log.warning(String.format(message, params))
    }

    /**
     * This method shows message window with warning information.
     *
     * @param message The warning message.
     */
    static errorMessage(String message, Object... params) {
        log.severe(String.format(message, params))
    }

}

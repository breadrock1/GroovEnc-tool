#!groovy

package org.example.grooven

import org.example.grooven.cli.CommandLineInterface
import org.example.grooven.log.Logger;


/**
 * There is main class to launch grooven-tool project.
 */
class App {
    static void main(String[] args) {
        try {
            CommandLineInterface commandLineInterface = CommandLineInterface.INSTANCE
            commandLineInterface.parse(args)
        } catch(Exception err) {
            Logger.errorMessage('Has been thrown critical error: ', err.getMessage())
            Logger.warningMessage('Process has been stopped!')
        }
    }
}

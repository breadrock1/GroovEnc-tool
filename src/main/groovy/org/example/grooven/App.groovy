#!groovy

package org.example.grooven

import org.example.grooven.cli.CommandLineInterface;


class App {
    static void main(String[] args) {
        CommandLineInterface commandLineInterface = CommandLineInterface.INSTANCE
        commandLineInterface.parse(args)
    }
}

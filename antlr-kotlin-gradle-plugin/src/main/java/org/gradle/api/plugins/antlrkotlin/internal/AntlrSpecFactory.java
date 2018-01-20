/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.plugins.antlrkotlin.internal;

import org.gradle.api.file.SourceDirectorySet;
import org.gradle.api.plugins.antlrkotlin.AntlrKotlinTask;
import org.gradle.internal.impldep.com.google.common.collect.Lists;

import java.io.File;
import java.util.List;
import java.util.Set;

public class AntlrSpecFactory {

    public AntlrSpec create(AntlrKotlinTask antlrTask, Set<File> grammarFiles, SourceDirectorySet sourceDirectorySet) {
        List<String> arguments = Lists.newLinkedList(antlrTask.getArguments());

        if (antlrTask.isTrace() && !arguments.contains("-trace")) {
            arguments.add("-trace");
        }
        if (antlrTask.isTraceLexer() && !arguments.contains("-traceLexer")) {
            arguments.add("-traceLexer");
        }
        if (antlrTask.isTraceParser() && !arguments.contains("-traceParser")) {
            arguments.add("-traceParser");
        }
        if (antlrTask.isTraceTreeWalker() && !arguments.contains("-traceTreeWalker")) {
            arguments.add("-traceTreeWalker");
        }

        return new AntlrSpec(arguments, grammarFiles, sourceDirectorySet.getSrcDirs(), antlrTask.getOutputDirectory(), antlrTask.getMaxHeapSize());
    }
}

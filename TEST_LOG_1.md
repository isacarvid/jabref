``` MacBook-Pro-de-Eva:jabref evadespinoy$ ./gradlew test

> Configure project :
Project : => 'org.jabref' Java module

> Task :compileJava
Skipped patching fastparse_2.12-1.0.0.jar into test
Skipped patching fastparse-utils_2.12-1.0.0.jar into test2
Skipped patching sourcecode_2.12-0.1.4.jar into test3
Note: Some input files use or override a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
Note: Some input files use unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

> Task :compileTestJava
Skipped patching fastparse_2.12-1.0.0.jar into test
Skipped patching fastparse-utils_2.12-1.0.0.jar into test2
Skipped patching sourcecode_2.12-0.1.4.jar into test3
warning: [options] --add-opens has no effect at compile time
warning: module name in --add-reads option not found: org.kordamp.ikonli.IkonHandler
warning: module name in --add-reads option not found: org.kordamp.ikonli.IkonProvider
Note: Some input files use or override a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
Note: /Users/evadespinoy/Downloads/jabref/src/test/java/org/jabref/model/TreeNodeTest.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
3 warnings

> Task :test
Running tests on classpath

org.jabref.architecture.MainArchitectureTests

Test respectLayeredArchitecture SKIPPED

org.jabref.migrations.MergeReviewIntoCommentActionMigrationTest

Test reviewAndCommentField() SKIPPED
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended

org.jabref.logic.layout.format.LatexToUnicodeFormatterTest

Test testCombiningAccentsCase2() SKIPPED
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.mockito.internal.util.reflection.ReflectionMemberAccessor (file:/Users/evadespinoy/.gradle/caches/modules-2/files-2.1/org.mockito/mockito-core/3.7.7/5d43943be9b57c8ff47d2b9640ea0a7fc7211cf2/mockito-core-3.7.7.jar) to constructor java.util.Optional(java.lang.Object)
WARNING: Please consider reporting this to the maintainers of org.mockito.internal.util.reflection.ReflectionMemberAccessor
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release

org.jabref.logic.citationstyle.CitationStyleGeneratorTest

Test testIgnoreCarriageReturnNewLine() SKIPPED
Test testXslFoFormat() SKIPPED
Test testRtfFormat() SKIPPED
Test testHandleDiacritics() SKIPPED
Test testAsciiDocFormat() SKIPPED
Test testIgnoreNewLine() SKIPPED
Test testTextFormat() SKIPPED
Test testMissingCitationStyle() SKIPPED
Test testHtmlFormat() SKIPPED
Test testHandleAmpersand() SKIPPED

org.jabref.logic.citationstyle.CitationStyleTest

Test getDefault() SKIPPED
Test testDefaultCitation() SKIPPED

org.jabref.logic.remote.RemoteSetupTest

Test testPortAlreadyInUse() SKIPPED

org.jabref.gui.util.ThemeTest

Test liveReloadCssDataUrl() SKIPPED

org.jabref.gui.keyboard.KeyBindingsTabModelTest

Test testSaveNewKeyBindingsToPreferences() SKIPPED
Test testSetAllKeyBindingsToDefault() SKIPPED
Test testSetSingleKeyBindingToDefault() SKIPPED

SUCCESS: Executed 6307 tests in 3m 55s (20 skipped)


Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.8/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 5m 16s
12 actionable tasks: 7 executed, 5 up-to-date

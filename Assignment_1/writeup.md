1. What features do you like about Kotlin?
I enjoy Kotlin being staticly typed and requiring type annotations for function arguments and return values. 
2. Are there things you were expecting to find that you haven’t?
Not really, to be fair there wasn't anything in particular I was expecting, but nothing seemed to be missing.
3. What questions do you have?
I was wondering what setup is required to get Kotlin working in vscode, or if I should just stick with intellij.

<ins> Translating Code </ins>
Writing code in Kotlin wasn't too bad. It had the typical getting used to syntax of learning a new language, but nothing especially difficult. The main thing I ran into trouble with was Chars and Strings being different types, especially as I was translating code from Python. For example, you can add Strings to Strings, and Chars to Strings, but you can't add Chars to Chars. I also ran into trouble trying to print the type of a variable, which I learned you do via `::class.java.typeName`. I also had some issues with setting up unit tests, but found out the issue was not creating a seperate project, and got it all working in the end.

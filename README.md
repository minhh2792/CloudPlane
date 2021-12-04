## CloudPlane

A minecraft server fork of pufferfish with some more patches. This fork is mainly designed to fit the cloudcraft minecraft network.

### Downloads

CloudPlane can be downloaded through github actions on [this](https://github.com/CloudCraftProjects/CloudPlane/actions) page.

### Building

You need [JDK 17](https://adoptium.net/releases.html?variant=openjdk17&jvmVariant=hotspot), `git` and `patch`. _Building on Windows is untested and not recommended!_
After installing the dependencies, clone this repository using `git clone https://github.com/CloudCraftProjects/CloudPlane.git` (**DON'T DOWNLOAD THE ZIP**) and then run the following commands:

```shell
cd CloudPlane # Change to the directory you cloned the repository to
./gradlew applyPatches # Apply all patches
./gradlew createReobfPaperclipJar # Create the reobfuscated paperclip jar
```

The output file named `CloudPlane-paperclip-1.18-R0.1-SNAPSHOT-reobf.jar` can now be found in `build/libs`.

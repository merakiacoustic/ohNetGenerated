# Makefile for Windows
#

openhome_system=Windows

!if [cl 2>&1 | find "for x64" > nul] == 0
!message Detected 64-bit compiler.
openhome_architecture=x64
!elseif [cl 2>&1 | find "for 80x86" > nul] == 0
!message Detected 32-bit compiler.
openhome_architecture=x86
!elseif [cl 2>&1 | find "for x86" > nul] == 0
!message Detected 32-bit compiler.
openhome_architecture=x86
!else
!message Cannot tell if compiler is 32-bit or 64-bit. Please specify openhome_architecture=x64 or openhome_architecture=x86.
!endif

depsPlatform = Windows-$(openhome_architecture)

!if "$(debug)"=="1"
link_flag_debug = /debug
link_flag_debug_dll = $(link_flag_debug)
debug_specific_cflags = /MTd /Z7 /Od /RTC1
debug_csharp = /define:DEBUG /debug+
build_dir = Debug
openhome_configuration = Debug
android_ndk_debug = 1
!else
link_flag_debug =
link_flag_debug_dll = /debug /opt:ref
debug_specific_cflags = /MT /Ox
debug_csharp = /optimize+ /debug:pdbonly
build_dir = Release
openhome_configuration = Release
android_ndk_debug = 0
!endif

!message Building for system $(openhome_system), architecture $(openhome_architecture), configuration $(openhome_configuration)

# Macros used by Common.mak
ar = lib /nologo /out:$(objdir)
cflags_third_party = $(debug_specific_cflags) /W4 /EHsc /FR$(objdir) -DDEFINE_LITTLE_ENDIAN -DDEFINE_TRACE -D_CRT_SECURE_NO_WARNINGS
cflags = $(cflags_third_party) /WX
cppflags = $(cflags)
objdirbare = Build\Obj\Windows\$(build_dir)
objdir = $(objdirbare)^\
header_install = Build\Include
inc_build = dependencies\$(depsPlatform)\ohNet-$(depsPlatform)-$(openhome_configuration)\include\ohnet
includes = -I$(inc_build)
bundle_build = Build\Bundles
osdir = Windows
objext = obj
libprefix =
libext = lib
sharedlibprefix = 
sharedlibext = lib
exeext = exe
compiler = cl /nologo /Fo$(objdir)
link = link /nologo $(link_flag_debug) /SUBSYSTEM:CONSOLE /map Ws2_32.lib Iphlpapi.lib Dbghelp.lib /incremental:no
linkoutput = /out:
dllprefix =
dllext = dll
linkopts_ohNet =
link_dll = link /nologo $(link_flag_debug_dll) /map Ws2_32.lib Iphlpapi.lib Dbghelp.lib /dll
csharp = csc /nologo /platform:anycpu
csharpdefines = 
publicjavadir = OpenHome\Net\Bindings\Java^\
includes_jni = -I"$(JAVA_HOME)\include" -I"$(JAVA_HOME)\include\win32"
link_jvm = "$(JAVA_HOME)\lib\jvm.lib"
java_cflags = $(cflags)
javac =  "$(JAVA_HOME)\bin\javac.exe"
jar =  "$(JAVA_HOME)\bin\jar.exe"
jarflags = cf
android_build_dir = OpenHome/Net/Bindings/Android/libs/
dirsep = ^\
installdir = $(PROGRAMFILES)\ohNet
installlibdir = $(installdir)\lib
installincludedir = $(installdir)\include
mkdir = Scripts\mkdir.bat
rmdir = Scripts\rmdir.bat
uset4 = no

default : all

include T4Windows.mak
# Actual building of code is shared between platforms
include Common.mak

!if "$(uset4)"=="yes"
build_targets = $(all_targets) tt
!else
build_targets = $(all_targets)
!endif

!if "$(uset4)"=="yes"
!include Generated\GenerateSourceFiles.mak
!endif

!include Generated\Proxies.mak
!include Generated\Devices.mak

include UserTargets.mak

# Following macros must be provided by each file which wraps Common.mak

make_obj_dir:
	if not exist $(objdirbare) mkdir $(objdirbare)

copy_build_includes:
	if not exist $(header_install) mkdir $(header_install)
	if not exist $(header_install)\OpenHome mkdir $(header_install)\OpenHome
	if not exist $(header_install)\OpenHome\Net mkdir $(header_install)\OpenHome\Net
	if not exist $(header_install)\OpenHome\Net\Core mkdir $(header_install)\OpenHome\Net\Core
	if not exist $(header_install)\OpenHome\Net\C mkdir $(header_install)\OpenHome\Net\C
	if not exist $(header_install)\OpenHome\Net\Cpp mkdir $(header_install)\OpenHome\Net\Cpp
	copy OpenHome\Net\ControlPoint\Proxies\*.h $(header_install)\OpenHome\Net\Core > nul
	copy OpenHome\Net\Device\Providers\*.h $(header_install)\OpenHome\Net\Core > nul
	copy OpenHome\Net\Bindings\C\ControlPoint\Proxies\*.h $(header_install)\OpenHome\Net\C > nul
	copy OpenHome\Net\Bindings\C\Device\Providers\*.h $(header_install)\OpenHome\Net\C > nul
	copy OpenHome\Net\Bindings\Cpp\ControlPoint\Proxies\*.h $(header_install)\OpenHome\Net\Cpp > nul
	copy OpenHome\Net\Bindings\Cpp\Device\Providers\*.h $(header_install)\OpenHome\Net\Cpp > nul

bundle-after-build: $(all_targets)
	if not exist "$(bundle_build)" mkdir "$(bundle_build)"
	python bundle_binaries.py --system $(openhome_system) --architecture $(openhome_architecture) --configuration $(openhome_configuration)
	python bundle_binaries.py --system $(openhome_system) --architecture $(openhome_architecture) --configuration $(openhome_configuration) --managed

bundle:
	if not exist "$(bundle_build)" mkdir "$(bundle_build)"
	python bundle_binaries.py --system $(openhome_system) --architecture $(openhome_architecture) --configuration $(openhome_configuration)
	python bundle_binaries.py --system $(openhome_system) --architecture $(openhome_architecture) --configuration $(openhome_configuration) --managed

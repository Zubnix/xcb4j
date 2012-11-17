Xcb4j is the X C binding's library made available for Java. SWiG is used to generate the bindings, based on the SWiG configuration files. The generated library is still very rudimentary but should work. I invite everybody using this library to improve the generation of the Java code by custimizing and adapting the SWiG configuration files and sending me a pull request. Currently a large number of Xcb modules is required to make the code generation workand the result is a large monolithic library. Ideally this should be split up in different maven modules. Other improvements consist of manually mapping methods that use C pointers and arrays to either Java native ByteBuffers or Java primitive arrays depending on performance and use-case of the Xcb method. This library was originaly created to be used by the Trinity Desktop Shell, see https://github.com/Zubnix/trinityshell  
  
Currently Xcb4j expects the following headers to be present during code generation:
- xcb/xcb.h
- xcb/xproto.h
- xcb/damage.h
- xcb/shape.h
- xcb/sync.h
- xcb/xcb_icccm.h
- xcb/xcb_keysyms.h
- xcb/xcb_util.h
- xcb/xfixes.h
- xcb/composite.h
- xcb/render.h
- xcb/xcb_atom.h
- xcb/xcb_ewmh.h
  
Xcb4j links the generated native jni library to the following xcb libraries during compilation:
- xcb
- xcb-keysyms
- xcb-util
- xcb-damage
- xcb-composite
- xcb-render
- xcb-sync
- xcb-shape
- xcb-xfixes

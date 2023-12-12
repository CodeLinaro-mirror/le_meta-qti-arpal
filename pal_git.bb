inherit autotools pkgconfig

DESCRIPTION = "pal"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM += "file://Pal.cpp;beginline=30;endline=31;md5=4a19879b8f612e3e0cd49fa53a83dc36 \
                     file://inc/PalDefs.h;beginline=30;endline=31;md5=0f37b80cb1f8d808a27cca9f0cb5e0ac"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://audio/opensource/arpal-lx/ \
            file://0001-pal-pal-patch.patch"

S = "${WORKDIR}/audio/opensource/arpal-lx"
PR = "r0"
DEPENDS = "tinyalsa tinycompress agm mm-audio-headers audioroute"

EXTRA_OECONF += "--with-glib --with-syslog"
EXTRA_OECONF += "--with-basemachine=${BASEMACHINE}"

SOLIBS = ".so"

FILES_SOLIBSDEV = ""

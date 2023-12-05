inherit autotools pkgconfig

DESCRIPTION = "Common mm-audio headers installation"

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://PalDefs.h;beginline=2;endline=31;md5=04cae86496fd516b7d823022a8b9c169"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI = "file://audio/opensource/arpal-lx/inc"

S = "${WORKDIR}/audio/opensource/arpal-lx/inc"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"


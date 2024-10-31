inherit autotools pkgconfig

DESCRIPTION = "Common mm-audio headers installation"

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://PalDefs.h;beginline=30;endline=31;md5=e733afaf233fbcbc22769d0a9bda0b3e"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI = "file://vendor/qcom/opensource/pal/inc"

S = "${WORKDIR}/vendor/qcom/opensource/pal/inc"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"


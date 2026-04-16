inherit autotools pkgconfig

DESCRIPTION = "mcs"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/qal/mcs/"
S = "${WORKDIR}/vendor/qcom/opensource/qal/mcs/"

EXTRA_OECONF += "--with-acdbdata=${STAGING_INCDIR}/acdbdata"

DEPENDS = "osal qal glib-2.0"
PR = "r0"

EXTRA_OECONF += "--with-glib"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

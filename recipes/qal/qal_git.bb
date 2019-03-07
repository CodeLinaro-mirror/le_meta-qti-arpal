inherit autotools pkgconfig

DESCRIPTION = "qal"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/qal/"

S = "${WORKDIR}/vendor/qcom/opensource/qal/"
PR = "r0"

DEPENDS = "tinyalsa gsl libcutils libhardware liblog system-media"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

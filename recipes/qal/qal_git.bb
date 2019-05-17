inherit autotools pkgconfig

DESCRIPTION = "qal"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/qal/"
SRC_URI += "file://${BASEMACHINE}/"

S = "${WORKDIR}/vendor/qcom/opensource/qal/"
PR = "r0"
DEPENDS = "tinyalsa system-media gsl expat glib-2.0"

EXTRA_OECONF += "--with-glib"

do_install_append() {
       install -d ${D}${sysconfdir}
       install -m 0755 ${WORKDIR}/${BASEMACHINE}/* ${D}${sysconfdir}/
}

SOLIBS = ".so"

FILES_SOLIBSDEV = ""

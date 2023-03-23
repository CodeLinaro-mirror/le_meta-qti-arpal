inherit autotools pkgconfig

DESCRIPTION = "pal"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=3775480a712fc46a69647678acb234cb"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/pal/"

S = "${WORKDIR}/vendor/qcom/opensource/pal/"
PR = "r0"
DEPENDS = "tinyalsa audio-route capiv2-headers tinycompress agm media-headers"

pkg_postinst_ontarget_${PN}(){
    chmod o+x /data/misc
}

EXTRA_OECONF += "--with-glib"
EXTRA_OECONF += "--with-basemachine=${BASEMACHINE}"

SOLIBS = ".so"

FILES_SOLIBSDEV = ""

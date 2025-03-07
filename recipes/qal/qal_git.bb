inherit autotools pkgconfig

DESCRIPTION = "pal"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
                    file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/pal/"
SRC_URI += "${@bb.utils.contains('BASEMACHINE', 'qcm2290-mtp', 'file://${BASEMACHINE}/', '', d)}"
SRC_URI += "${@bb.utils.contains('BASEMACHINE', 'qcm4325-mtp', 'file://qcm2290-mtp/', '', d)}"
SRC_URI += "${@bb.utils.contains('BASEMACHINE', 'qcm2290-mtp qcm4325-mtp', '', 'file://${BASEMACHINE}/', d)}"

S = "${WORKDIR}/vendor/qcom/opensource/pal/"
PR = "r0"
DEPENDS = "tinyalsa audio-route mm-audio-headers tinycompress agm media-headers qal-headers"

EXTRA_OECONF += "--with-glib"
EXTRA_OECONF += "--with-acdbdata=${STAGING_INCDIR}/acdbdata"

do_install:append() {
       install -d ${D}${sysconfdir}
       if [ "${BASEMACHINE}" != "qcm4325-mtp" ]; then
           install -m 0755 ${WORKDIR}/${BASEMACHINE}/* ${D}${sysconfdir}/
       fi
       if [ "${BASEMACHINE}" == "qcm4325-mtp" ]; then
           install -m 0755 ${WORKDIR}/qcm2290-mtp/* ${D}${sysconfdir}/
       fi
}

SOLIBS = ".so"

FILES_SOLIBSDEV = ""

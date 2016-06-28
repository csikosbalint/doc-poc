<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="module">
        <h1 align="center">
            <xsl:apply-templates/>
        </h1>
    </xsl:template>

</xsl:stylesheet>
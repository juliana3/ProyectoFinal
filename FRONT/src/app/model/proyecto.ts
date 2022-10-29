export class Proyecto {
    id?: number;
    nombrePr: string;
    descripcionPr: string;
    linkPr: string;

    constructor(nombrePr:string, descripcionPr: string, linkPr:string){
        this.nombrePr = nombrePr;
        this.descripcionPr = descripcionPr;
        this.linkPr = linkPr;
    }
}
